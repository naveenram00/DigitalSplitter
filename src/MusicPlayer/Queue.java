package MusicPlayer;

import java.util.Arrays;

public class Queue {
		
		private String[] stackArray;
		public int stackSize;
		
		// Sets stack as empty
		
		private int topOfStack = -1;
		
		Queue(int size){
			
			stackSize = size;
			
			stackArray = new String[size];
			
			// Assigns the value of -1 to every value in the array
			// so I control what gets printed to screen
			
			Arrays.fill(stackArray, "-1");
			
		}

		public void push(String input){
			
			if(topOfStack+1 < stackSize){
				
				topOfStack++;
				
				stackArray[topOfStack] = input;
				
			} else System.out.println("Sorry But the Stack is Full");
			
			displayTheStack();
			
			System.out.println("PUSH " + input + " Was Added to the Stack\n");
			
		}
		
		public String pop(){
			
			if(topOfStack >= 0){
				
				displayTheStack();
				
				System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");
				
				// Just like in memory an item isn't deleted, but instead is just not available
				
				stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't appear
				
				return stackArray[topOfStack--];
		
				
			} else {
				
				displayTheStack();
				
				System.out.println("Sorry But the Stack is Empty");
				
				return "-1";
			}
			
			
		}
		
		public String peek(){
			
//			displayTheStack();
//			
			System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");
			
			return stackArray[topOfStack];
			
		}
		
		public void pushMany(String multipleValues){
			
			String[] tempString = multipleValues.split(" ");
			
			for(int i = 0; i < tempString.length; i++){
				
				push(tempString[i]);
				
			}
			
		}
		
		public void popAll(){
			
			for(int i = topOfStack; i >= 0; i--){
				
				pop();
				
			}
			
		}
		
		public void popDisplayAll(){
			
			String theReverse = "";
			
			for(int i = topOfStack; i >= 0; i--){
				
				theReverse += stackArray[i];
				
			}
			
			System.out.println("The Reverse: " + theReverse);
			
			popAll();
			
		}
		
		
		
		public void displayTheStack(){
			
				for(int n = 0; n < 61; n++)System.out.print("-");
				
				System.out.println();
				
				for(int n = 0; n < stackSize; n++){
					
					System.out.format("| %2s "+ " ", n);
					
				}
				
				System.out.println("|");
				
				for(int n = 0; n < 61; n++)System.out.print("-");
				
				System.out.println();
				
				for(int n = 0; n < stackSize; n++){
					
					
					
					if(stackArray[n].equals("-1")) System.out.print("|     ");
					
					else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
					
				}
				
				System.out.println("|");
				
				for(int n = 0; n < 61; n++)System.out.print("-");
				
				System.out.println();
			
		}
		
		public static void main(String[] args){
			
			Queue Queue = new Queue(10);
			
			Queue.push("10");
			Queue.push("17");
			Queue.push("13");
			
			// Look at the top value on the stack
			
			Queue.peek();
			
			// Remove values from the stack (LIFO)
			
			Queue.pop();
			Queue.pop();
			Queue.pop();
			
			// Add many to the stack
			
			Queue.pushMany("R E D R U M");
			
			// Remove all from the stack
			
			// Queue.popAll();
			
			// Remove all from the stack and print them
			
			Queue.popDisplayAll();
			
			Queue.displayTheStack();
			
			
		}
		
	}
