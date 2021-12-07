// # trie, store, querry

// 1032. Stream of Characters
// 1. define trie class:
//      has children array with length 26 to corresponding 26 chars
//      boolean isLeaf indicate if it was a whole word
// 2. store:
//      store each word use upside down order, 
//      last char in a word stored first,
//      the height of trie is the length of longest word
// 3. querry:
//      querry letter stored into arraylist,
//      iterate each letter from tail of al,
//      if found match return true,
//      after al was done search or current node is null, false



class StreamChecker {
    ArrayList<Character> al;
    TrieNode root;
    public StreamChecker(String[] words) {
        al = new ArrayList<>();
        root = new TrieNode();
        
        for(String word:words){
            TrieNode node = root;
            
            for(int i=word.length()-1;i>=0;i--){
                if(node.children[word.charAt(i)-'a']==null){
                     node.children[word.charAt(i)-'a']=new TrieNode();   
                }
                node = node.children[word.charAt(i)-'a'];   
            }
            node.isLeaf=true;
        }
    }
    
    public boolean query(char letter) {
        al.add(letter);
        TrieNode node = root;
        for( int i=al.size()-1;i>=0;i--){
            node=node.children[al.get(i)-'a'];
            if(node==null) break;
            if(node.isLeaf) return true;
        }
        return false;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isLeaf;
    TrieNode(){
        children=new TrieNode[26];
        isLeaf =false;
    }
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */