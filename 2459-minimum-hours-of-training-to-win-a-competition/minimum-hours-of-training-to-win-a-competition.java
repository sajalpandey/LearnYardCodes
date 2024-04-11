class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int requiredHours = 0;
        for(int i=0; i<energy.length; i++) {
            if(initialEnergy > energy[i]) {
                initialEnergy -= energy[i];
            } else {
                requiredHours += ++energy[i] - initialEnergy;
                initialEnergy = 1;
            }
            //System.out.print(initialEnergy+" ");
            if(initialExperience > experience[i])
                initialExperience += experience[i];
            else {
                int reqquired = experience[i] - initialExperience +1;
                requiredHours += reqquired;
                initialExperience += experience[i] + reqquired ;
            }
        }
        return requiredHours;
    }
}