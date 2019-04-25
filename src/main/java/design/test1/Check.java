package design.test1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Check{

	private final static double REPEAT_RATE = 0.6f;
	// you can add your data-structure here
	private static List<Set<Character>> standardDocFeatureList = null;

	private BitSet wordBitSet = null;

	private Map<Character,Integer> wordBitMap = null;

	private Map<String,BitSet> wordBitSetMap = null;

	private List<BitSet> bitSets = null;

	private int index = 0;

	// you must rewrite this function
	public void init(Vector<String> docList){
		standardDocFeatureList = new LinkedList<Set<Character>>();
		int docListSize = docList.size();
		wordBitMap = new HashMap<Character, Integer>(1024);
		wordBitSetMap = new HashMap<String, BitSet>(1024);
		bitSets = new ArrayList<BitSet>();
		for(int i = 0; i < docListSize ; i++){
			String doc = docList.get(i);
			if(doc != null && doc.length() > 0){
				getDocFeature(doc);
			}
		}
	}
	//my function
	private void getDocFeature(String doc){
		BitSet bitSet = new BitSet();
		int docSize = doc.length();
		for(int i = 0 ; i < docSize ; i++){
			Character key = doc.charAt(i);
			buildWordBit(key);
			bitSet.set(wordBitMap.get(key));
		}
		bitSets.add(bitSet);
	}

	private void buildWordBit(Character character){
		if(wordBitMap.get(character) == null){
			wordBitMap.put(character,++index);
		}
	}
	// you must rewrite this function
	// checking
	// IN tiezi : doc string
	// OUT : 1=>hit doc
	//       0=>miss doc
	public int check(char [] info , int  infoLen){
		// compare all items
		BitSet target = new BitSet();
		for(int i = 0 ; i  < infoLen ; i ++ ){
			buildWordBit(info[i]);
			target.set(wordBitMap.get(info[i]));
		}
		BitSet temp = new BitSet();
		BitSet source = null;
		int prelength = -1;
		int afterlength = -1;
		double rate = 0.0;
		for(int i = 0; i < bitSets.size();i++){
			temp.clear();
			temp.or(target);
			source = bitSets.get(i);
			prelength = source.cardinality();
			temp.and(source);
			afterlength = temp.cardinality();
			rate = (double)afterlength/(double)prelength;
			if(rate > REPEAT_RATE){
				return 1;
			}
		}
		return 0;
	}

}

