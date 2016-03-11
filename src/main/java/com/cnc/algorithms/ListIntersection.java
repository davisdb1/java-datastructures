package com.cnc.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Evan Harris
 */
public class ListIntersection {
    
    //Assuming that numbers in each list are unique
    public List<Integer> findIntersectionOfLists(List<Integer>[] inputLists){

        Map<Integer, Integer> occurenceCounts = new HashMap<Integer, Integer>();
        for(List<Integer> intList : inputLists){
            for(Integer integer : intList) {
                if(occurenceCounts.containsKey(integer)){
                    occurenceCounts.put(integer, occurenceCounts.get(integer) + 1);
                }
                else{
                    occurenceCounts.put(integer, 1);
                }
            }
        }
        
        List<Integer> outputList = new LinkedList<Integer>();
        for(Integer occuredInt : occurenceCounts.keySet()){
            Integer numberOfOccurences = occurenceCounts.get(occuredInt);
            if(numberOfOccurences == inputLists.length){
                outputList.add(occuredInt);
            }
        }
        
        return outputList;
    }
    
    //Assuming that the numbers in each list can contain duplicates
    public int[] findIntersectionOfListsWithDuplicates(int[][] inputLists){
        
        //populate intersection set with first list
        int[] currentIntersection = inputLists[0];
        for(int listIndex = 1; listIndex < inputLists.length && currentIntersection.length > 0; listIndex++){
            
            int[] comparingArray = inputLists[listIndex];
            int[] output = new int[Math.min(currentIntersection.length,comparingArray.length)];
            int outputIndex=0;
            if(currentIntersection.length > 0 && comparingArray.length > 0){
                Arrays.sort(currentIntersection);
                Arrays.sort(comparingArray);
                int i=0, j=0;
                while ( i < currentIntersection.length && j < comparingArray.length ) {
                    if (currentIntersection[i] > comparingArray[j]) {
                        i++;
                    }
                    else if (currentIntersection[i] < comparingArray[j]) {
                        j++;
                    }
                    else {
                        int added = output[outputIndex++] = currentIntersection[i];

                        //handles not printing duplicates by skipping over them
                        while(i < currentIntersection.length
                                && j < comparingArray.length
                                && currentIntersection[i] == comparingArray[j]
                                && currentIntersection[i] == added
                                ) {
                            j++;
                            i++;
                        }
                    }
                }
            }
            currentIntersection = Arrays.copyOf(output, outputIndex);    
        }
        return currentIntersection;
    }



    //Assuming that the numbers in each list can contain duplicates
    public int[] findIntersectionOfListsWithDuplicatesUsingMap(int[][] inputLists){

        //populate intersection set with first list
        int[] currentIntersection = inputLists[0];
        for(int listIndex = 1; listIndex < inputLists.length && currentIntersection.length > 0; listIndex++){
            int[] comparingArray = inputLists[listIndex];
            Set<Integer> comparingArraySet = new HashSet<Integer>();
            int[] shortArray = comparingArray.length > currentIntersection.length ? currentIntersection : comparingArray;
            int[] longArray = comparingArray.length < currentIntersection.length ? currentIntersection : comparingArray;
            
            for(int shortArrayValue : shortArray){
                comparingArraySet.add(shortArrayValue);
            }
            for(int longArrayValue : longArray){
                if(!comparingArraySet.contains(longArrayValue)){
                    comparingArraySet.remove(longArrayValue);
                }
            }
            comparingArray = new int[comparingArraySet.size()];
            int comparingArrayIndex = 0;
            for(Integer intersectionInt : comparingArraySet){
                comparingArray[comparingArrayIndex++] = intersectionInt;
            }
        }
        return currentIntersection;
    }
    
}
