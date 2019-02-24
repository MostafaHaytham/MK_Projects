/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bb
 */
public class FinalDB {

    public static ArrayList<String> ranks = new ArrayList<String>();
    public static ArrayList<String> names = new ArrayList<String>();
    public static ArrayList<String> codes = new ArrayList<String>();
    public static ArrayList<String> jobs = new ArrayList<String>();
    public static ArrayList<String> areas = new ArrayList<String>();
    public static ArrayList<String> tournaments = new ArrayList<String>();
    public static ArrayList<String> startDate = new ArrayList<String>();
    public static ArrayList<String> endDate = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> teams = new ArrayList<ArrayList<String>>();
    
    public static Set<String> ranksList = new HashSet<String>();
    public static Set<String> jobsList = new HashSet<String>();
    public static Set<String> areasList = new HashSet<String>();
    public static Set<String> tournamentsList = new HashSet<String>();
    public static Set<String> teamsList = new HashSet<String>();
    public static int amountOfUsers = 0;

    public static void setArrays(String fileName) {
        ranks = new ArrayList<String>();
        names = new ArrayList<String>();
        codes = new ArrayList<String>();
        jobs = new ArrayList<String>();
        areas = new ArrayList<String>();
        tournaments = new ArrayList<String>();
        startDate = new ArrayList<String>();
        endDate = new ArrayList<String>();
        teams = new ArrayList<ArrayList<String>>();
        ranksList = new HashSet<String>();
        jobsList = new HashSet<String>();
        areasList = new HashSet<String>();
        tournamentsList = new HashSet<String>();
        teamsList = new HashSet<String>();
        int counter = 0;
        try {
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
            BufferedReader br = new BufferedReader(fileReader);
            String newLine = br.readLine();
            while (newLine != null) {
                String words[] = newLine.split("-&-");
                ranks.add(words[0]);
                ranksList.add(words[0]);
                names.add(words[1]);
                codes.add(words[2]);
                jobs.add(words[3]);
                jobsList.add(words[3]);
                areas.add(words[4]);
                areasList.add(words[4]);
                tournaments.add(words[5]);
                tournamentsList.add(words[5]);
                startDate.add(words[6]);
                endDate.add(words[7]);
                ArrayList<String> userTeams = new ArrayList<String>();
                for (int t = 8; t < words.length; t++) {
                    userTeams.add(words[t]);
                    teamsList.add(words[t]);
                }
                teams.add(userTeams);
                newLine = br.readLine();
            }
            amountOfUsers = ranks.size();
            br.close();
            fileReader.close();

        } catch (IOException ex) {

        }
    }

    public static void backupFile(String fileName) {
        try {
            File file = new File(fileName);
            Process p;
            p = Runtime.getRuntime().exec("attrib -h " + file.getPath());
            p.waitFor();
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (int i = 0; i < amountOfUsers; i++) {
                wr.append(ranks.get(i));
                wr.append("-&-");
                wr.append(names.get(i));
                wr.append("-&-");
                wr.append(codes.get(i));
                wr.append("-&-");
                wr.append(jobs.get(i));
                wr.append("-&-");
                wr.append(areas.get(i));
                wr.append("-&-");
                wr.append(tournaments.get(i));
                wr.append("-&-");
                wr.append(startDate.get(i));
                wr.append("-&-");
                wr.append(endDate.get(i));
                wr.append("-&-");
                for (int t = 0; t < teams.get(i).size(); t++) {
                    wr.append(teams.get(i).get(t));
                    if (t != teams.get(i).size() - 1) {
                        wr.append("-&-");
                    }
                }
                wr.newLine();
            }

            wr.close();
            p = Runtime.getRuntime().exec("attrib +h " + file.getPath());
            p.waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("data.txt");
            file.createNewFile();
            Process p;
            p = Runtime.getRuntime().exec("attrib +h " + file.getPath());
            p.waitFor();
        } catch (InterruptedException ie) {
        }

        setArrays("data.txt");
        backupFile("data2.txt");
        Search s = new Search();
        s.setVisible(true);

    }

}
