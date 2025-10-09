class Solution {
    public long minTime(int[] skill, int[] mana) {
        long sumSkill = 0;
        for (int s : skill) {
            sumSkill += s;
        }
        
        long prevWizardDone = sumSkill * mana[0];
        
        for (int j = 1; j < mana.length; j++) {
            long prevPotionDone = prevWizardDone;
            
            for (int i = skill.length - 2; i >= 0; i--) {
                // Calculate start time for wizard i brewing potion j
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                prevWizardDone = Math.max(prevPotionDone, 
                                         prevWizardDone - (long) skill[i] * mana[j]);
            }
            
            prevWizardDone += sumSkill * mana[j];
        }
        
        return prevWizardDone;
    }
}
