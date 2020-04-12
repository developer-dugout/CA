package com.coding.pixel.ca.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.coding.pixel.ca.Model.Posts;
import com.coding.pixel.ca.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {

    private View PrivateBlogPosts;
    private RecyclerView BlogPostsList;
    private DatabaseReference BlogPostsRef, UsersRef, likesRef;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private String currentUserID="";
    Boolean likesChecker = false;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PrivateBlogPosts = inflater.inflate(R.layout.fragment_home, container, false);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        BlogPostsRef = FirebaseDatabase.getInstance().getReference().child("posts").child(currentUserID);
        UsersRef = FirebaseDatabase.getInstance().getReference().child("users");

        //BlogPostsList =  PrivateBlogPosts.findViewById(R.id.blog_post_list);
        //BlogPostsList.setLayoutManager(new LinearLayoutManager(getContext()));

        //DisplayAllUsersPosts();

        return PrivateBlogPosts;
    }

    private void DisplayAllUsersPosts() {

        Query postInOrder = BlogPostsRef.orderByChild("counter");

        FirebaseRecyclerOptions<Posts> options=new FirebaseRecyclerOptions.Builder<Posts>().setQuery(postInOrder,Posts.class).build();
        final FirebaseRecyclerAdapter<Posts, PostsViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Posts, PostsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PostsViewHolder holder, int position, @NonNull Posts model) {

                final String PostKey = getRef(position).getKey();

                holder.username.setText(model.getName());
                holder.time.setText(" at " +model.getTime());
                holder.date.setText(" "+model.getDate());
                holder.description.setText(model.getDescription());
                Picasso.get().load(model.getImage()).into(holder.user_post_image);
                Picasso.get().load(model.getPostimage()).into(holder.postImage);

                holder.setLikeButtonStatus(PostKey);

                holder.likePost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        likesChecker = true;

                        likesRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                            {
                                if (likesChecker.equals(true))
                                {
                                    if (dataSnapshot.child(PostKey).hasChild(currentUserID))
                                    {
                                        likesRef.child(PostKey).child(currentUserID).removeValue();
                                        likesChecker = false;
                                    }
                                    else
                                    {
                                        likesRef.child(PostKey).child(currentUserID).setValue(true);
                                        likesChecker = false;
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
                /*holder.commentPost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent commentIntent = new Intent(HomeFragment.this, CommentsActivity.class);
                        commentIntent.putExtra("PostKey" , PostKey);
                        startActivity(commentIntent);
                    }
                });*/
            }
            @NonNull
            @Override
            public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.all_blog_post_layout,parent,false);
                PostsViewHolder viewHolder=new PostsViewHolder(view);
                return viewHolder;
            }
        };
        firebaseRecyclerAdapter.startListening();
        BlogPostsList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class PostsViewHolder extends RecyclerView.ViewHolder{
        TextView username,date,time,description, noOfLikes;
        CircleImageView user_post_image;
        ImageView postImage;
        ImageButton likePost, commentPost;
        int countsLikes;
        String currentUserID;
        DatabaseReference LikesRef;

        public PostsViewHolder(View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.post_user_name);
            date=itemView.findViewById(R.id.post_date);
            time=itemView.findViewById(R.id.post_time);
            description=itemView.findViewById(R.id.post_description);
            postImage=itemView.findViewById(R.id.post_image);
            user_post_image=itemView.findViewById(R.id.user_profile_image);
            likePost = itemView.findViewById(R.id.like_btn);
            commentPost = itemView.findViewById(R.id.comment_btn);
            noOfLikes = itemView.findViewById(R.id.display_no_of_likes);

            LikesRef = FirebaseDatabase.getInstance().getReference().child("Likes");
            currentUserID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }

        public void setLikeButtonStatus(final String PostKey)
        {
            LikesRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {
                    if (dataSnapshot.child(PostKey).hasChild(currentUserID))
                    {
                        countsLikes = (int) dataSnapshot.child(PostKey).getChildrenCount();
                        likePost.setImageResource(R.drawable.like);
                        noOfLikes.setText(Integer.toString(countsLikes)+(" Likes"));
                    }
                    else
                    {
                        countsLikes = (int) dataSnapshot.child(PostKey).getChildrenCount();
                        likePost.setImageResource(R.drawable.dislike);
                        noOfLikes.setText(Integer.toString(countsLikes)+(" Likes"));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
