package com.cnc.algorithms;

/**
 *
 * Given n light bulbs, write two methods. 

 isOn(i) to determine if a light bulb is on 
 toggle(start, end) to toggle all the light bulbs in the range 

 One caveat, write toggle so that it is less than O(n) complexity
 http://www.careercup.com/question?id=5668664122540032

 * @author Evan Harris
 */
public class LightBulbController {

    private int[] bulbs;

    private LightBulbController(){ }

    public static LightBulbController withNumberOfBulbs(int numberOfBulbs){
        if(numberOfBulbs <= 0){
            throw new IllegalArgumentException("Must have 0 or more bulbs");
        }
        LightBulbController lightBulbController = new LightBulbController();
        lightBulbController.bulbs = new int[numberOfBulbs];
        return lightBulbController;
    }

    public void toggle(int startingBulb, int endingBulb){
        checkBulbIndex(startingBulb);
        checkBulbIndex(endingBulb);

        bulbs[startingBulb] = 1;

        if(endingBulb < bulbs.length){
            bulbs[endingBulb + 1] = -1;
        }
    }

    public boolean isOn(int bulbNumber){
        checkBulbIndex(bulbNumber);
        int runningTotal = 0;
        for(int i = 0; i <= bulbNumber; i++){
            runningTotal += bulbs[i];
        }
        return runningTotal % 2 == 1;
    }

    private void checkBulbIndex(int index){
        if(index <= 0){
            throw new IllegalArgumentException("Bulb index cannot be negative");
        }else if(index >= bulbs.length){
            throw new IllegalArgumentException("Bulb index cannot greater that number of bulbs");
        }
    }

}
