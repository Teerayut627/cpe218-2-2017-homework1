import java.util.Stack;
import java.util.Scanner;

public class Homework1 {

	public static Stack<Character> queStack = new Stack<Character>();
    public static Node tree;


	
	public static void main(String[] args) {
		// Begin of arguments input sample
        System.out.print("input : ");
        Scanner Question = new Scanner(System.in);
        String input = Question.nextLine();

//        if(args.length >0){
//            input = args[0];
//            if(input.equalsIgnoreCase("251-*32*+")){
//                System.out.print("(2*(5-1))+(3*2)=14");
//            }
//        }
		// End of arguments input sample
		// TODO: Implement your project here

        for(int i = 0; i < input.length(); i++)
        {
            queStack.add(input.charAt(i));
        }

        tree = new Node(queStack.pop());
        infix(tree);
        inorder(tree);


        System.out.print(" = ");
        System.out.print(calculate(tree));

        TreeDemo.main(args);

    }

    static class Node{

        public String toString()
        {
            return data.toString();
        }

	    Character data;
        Node left;
        Node right;
        public Node(char key)
        {
            data = key;
            left = null;
            right = null;
        }

    }

    static void infix(Node n){

        if(n.data == '+' || n.data == '*' ||  n.data == '-' ||  n.data == '/'){
                
            n.right = new Node(queStack.pop());
            infix(n.right);

            n.left = new Node(queStack.pop());
            infix(n.left);
        }
    }
           
    static void inorder(Node n){
        
        if(n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/')
        {
            if(n!=tree)
            {
                System.out.print("(");
            }
            inorder(n.left);
            System.out.print(n.data);
            inorder(n.right);
            if(n!=tree)
            {
                System.out.print(")");
            }

        }else{

            System.out.print(n.data);
            }
    }
        
    static int calculate(Node n) {

        if (n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/') {

            if (n.data == '+') {
                return calculate(n.left) + calculate(n.right);
            }
            if (n.data == '-') {
                return calculate(n.left) - calculate(n.right);
            }
            if (n.data == '*') {
                return calculate(n.left) * calculate(n.right);
            }
            if (n.data == '/') {
                return calculate(n.left) / calculate(n.right);
            }
        }
        return Integer.parseInt(n.data.toString());
	}
}


