package com.nasr;

import java.util.ArrayList;

enum VottingState {single, multiple}

public class Votting {
    final VottingState vottingState;
    final String question;
    final String[] options;

    public Votting(VottingState vottingState, String question, String[] options) {
        this.vottingState = vottingState;
        this.question = question;
        this.options = options;
    }

    /*
     *the index of voters option in options
     */
    private ArrayList<Integer> votes;

    int voteCounts() {
        return votes.size();
    }

    String result() {
        Integer[] resultVotes = new Integer[options.length];
        for (Integer vote : votes) {
            resultVotes[vote]++;
        }
        StringBuilder stb = new StringBuilder();
        for (int index = 0; index < voteCounts(); index++) {
            stb.append("Option " + index + " has reached: " + resultVotes[index] + '\n');
        }
        return stb.toString();
    }
}
