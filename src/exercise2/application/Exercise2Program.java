package exercise2.application;

import exercise2.entities.Comment;
import exercise2.entities.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercise2Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Post> posts = new ArrayList<>();

        Boolean post = null;

        while(post == null){
            System.out.print("Do you want to make a post? (Yes/No): ");
            String answer = sc.nextLine().trim().toLowerCase();

            if(answer.equals("yes")) {
                LocalDateTime postMoment = LocalDateTime.now();

                System.out.print("Make a post title: ");
                String title = sc.nextLine();

                System.out.print("Make the post content: ");
                String content = sc.nextLine();

                System.out.print("Do you want to make the first like? (Yes/No): ");
                String firstLikeString = sc.nextLine().trim().toLowerCase();
                int firstLike = 0;
                if(firstLikeString.equals("yes")){
                    firstLike = 1;
                }

                Post newPost = new Post(postMoment, title, content, firstLike);
                posts.add(newPost);

                System.out.print("Do you want to make a comment? (Yes/No): ");
                String newComment = sc.nextLine().trim().toLowerCase();
                if(newComment.equals("yes")){
                    System.out.print("Make a comment: ");
                    Comment comment = new Comment(sc.nextLine());
                    posts.getLast().addComment(comment);
                }
            }

            else if(answer.equals("no")) {
                System.out.println("Ending posts.");
                post = false;
            } else{
                System.out.println("Answer invalid.");
            }
        }
        for(Post p : posts){
            System.out.println(p + "\n");
        }

        sc.close();
    }

}
