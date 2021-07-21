package com.nasr;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.*;

public class VottingSystem {
    ArrayList<Votting> vottings = new ArrayList<>();
    HashMap<User, Votting> users = new HashMap<>();

    void addVotting(
            VottingState vottingState,
            String question,
            String[] options
    ) {
        vottings.add(new Votting(vottingState, question, options));
    }

    void removeVoting(int index) {
        vottings.remove(index);
    }

    void addUserVote(User user, Votting votting) {
        Iterator it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            if (pair.getKey() == user) {
                it.remove(); // avoids a ConcurrentModificationException
                return;
            }
        }
        user.setDate(getCurrentDate());
        users.put(user, votting);
    }

    private String getCurrentDate() {
        Date date = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));

        return islamyDate.toString();
    }
}
