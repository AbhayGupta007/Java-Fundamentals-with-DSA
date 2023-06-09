package J_24_Tries;

import java.util.ArrayList;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class IsPallindrome {

	private TrieNode root;
	public int count;

	public IsPallindrome() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */


	public boolean isPalindromePair(ArrayList<String> words) {
		//Your code goes here
		String input1,p="";
        for(int i =0;i<words.size();i++){
            if(!search(root,words.get(i)))
                add(words.get(i));
        }
        for(int i =0;i<words.size();i++){
            p="";
            input1 = words.get(i);
            for(int k =0;k<input1.length();k++){
                p=input1.charAt(k)+p;
            }
            // System.out.println(p);
            if(search(root,p)){
                return true;
            }
		}
		for (int i = 0; i< words.size()-1; i++) 
            { 
                for (int j = i+1; j< words.size() ; j++) 
                { 
                    String check_str = ""; 

                    // concatenate both strings 
                    check_str = check_str + words.get(i) + words.get(j); 

                    // check if the concatenated string is 
                    // palindrome 
                    if (isPalindrome(check_str)) 
                        return true; 

                    check_str = words.get(j) + words.get(i); 

                    // check if the concatenated string is 
                    // palindrome 
                    if (isPalindrome(check_str)) 
                        return true; 
                } 
            } 
        return false;
	}
	static boolean isPalindrome(String str) 
    { 
        int len = str.length(); 
       
        // compare each character from starting 
        // with its corresponding character from last 
        for (int i = 0; i < len/2; i++ ) 
            if (str.charAt(i) != str.charAt(len-i-1)) 
                return false; 
       
        return true; 
    } 
	
} 