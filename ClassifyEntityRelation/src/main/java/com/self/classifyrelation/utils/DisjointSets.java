package com.self.classifyrelation.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Disjoint data structure to identify the connection between the elements either by direct or indirect.
 * 
 * @author ranjithr
 *
 */
public class DisjointSets {
	private List<Map<Integer, Set<Integer>>> disjointSet;
	 
    public DisjointSets() {
        disjointSet = new ArrayList<>();
    }
 
    /**
     * Initialize the elements by considering that each element as root
     * 
     * @param element
     */
    public void initialize(int element) {
        Map<Integer, Set<Integer>> groupsWithRelationMap = new HashMap<>();
        Set<Integer> groupedEntitySet = new HashSet<>();
        
        groupedEntitySet.add(element);
        groupsWithRelationMap.put(element, groupedEntitySet);
        
        disjointSet.add(groupsWithRelationMap);
    }
 
    /**
     * Group the element based on the relation between each other
     * 
     * @param first
     * @param second
     */
    public void union(int first, int second) {
        int firstRep = find(first);
        int secondRep = find(second);
 
        Set<Integer> firstSet = null;
        Set<Integer> secondSet = null;
 
        for (int index = 0; index < disjointSet.size(); index++) {
            Map<Integer, Set<Integer>> groupsWithRelationMap = disjointSet.get(index);
            
            if (groupsWithRelationMap.containsKey(firstRep)) {
                firstSet = groupsWithRelationMap.get(firstRep);
            } else if (groupsWithRelationMap.containsKey(secondRep)) { 
                secondSet = groupsWithRelationMap.get(secondRep);
            }
        }
 
        if (firstSet != null && secondSet != null) {
        	 firstSet.addAll(secondSet);
        }
       
 
        for (int index = 0; index < disjointSet.size(); index++) {
            Map<Integer, Set<Integer>> reorderGroupsByRelationMap = disjointSet.get(index);
            
            if (reorderGroupsByRelationMap.containsKey(firstRep)) {
            	reorderGroupsByRelationMap.put(firstRep, firstSet);
            } else if (reorderGroupsByRelationMap.containsKey(secondRep)) {
            	reorderGroupsByRelationMap.remove(secondRep);
                disjointSet.remove(index);
            }
        }
    }
 
    /**
     * Identify the parent element of given element and return that group
     * 
     * @param element
     * @return
     */
    public int find(int element) {
        for (int index = 0; index < disjointSet.size(); index++) {
            Map<Integer, Set<Integer>> groupsWithRelationMap = disjointSet.get(index);
            Set<Integer> keySet = groupsWithRelationMap.keySet();
            
            for (Integer key : keySet) {
                Set<Integer> set = groupsWithRelationMap.get(key);
                
                if (set.contains(element)) {
                    return key;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Fetch the grouped entities based on the relation that has built
     * 
     * @return
     */
    public List<Set<Integer>> group() {
    	List<Set<Integer>> groupedEntityList = new ArrayList<>();
    	
        for(Map<Integer, Set<Integer>> entityList : disjointSet) {
        	for(Map.Entry<Integer, Set<Integer>> currEntity : entityList.entrySet()) {
        		groupedEntityList.add(entityList.get(currEntity.getKey()));
        	}
        }
        
        return groupedEntityList;
    }
    
    /**
     * Clear the disjoint list and make it available for next process
     */
    public void clear() {
        disjointSet = new ArrayList<>();
    }
}
