// rdmello
package edu.syr.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    List<String> questions;
    public Questionnaire() {
        questions = new ArrayList<>();
    }
    public void addQuestion(String s) {
        questions.add(s);
    }

    private String getValidResponse(BufferedReader reader, String question) {
        while (true) {
            System.out.println(question);

            if (question.contains("Leikert")) {
                System.out.println("Please respond with an integer from 1 to 5:");
                System.out.println("1 - Strongly Agree");
                System.out.println("2 - Somewhat Agree");
                System.out.println("3 - Neutral");
                System.out.println("4 - Somewhat Disagree");
                System.out.println("5 - Strongly Disagree");
            } else {
                System.out.println("True or False: ");
            }

            try {
                String response = reader.readLine();

                if (isValidResponse(response, question)) {
                    return response;
                } else {
                    System.out.println("Invalid response. Please enter 'True', 'False', or a valid integer for Leikert scale.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidResponse(String response, String question) {
        if (question.contains("Leikert")) {
            try {
                int likertResponse = Integer.parseInt(response);
                return likertResponse >= 1 && likertResponse <= 5;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return response.equalsIgnoreCase("true") || response.equalsIgnoreCase("false");
        }
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: questions) {
            String response = getValidResponse(reader, s);
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addQuestion("Are you awake?");
        q.addQuestion("Have you had coffee?");
        q.addQuestion("Are you ready to get to work?");
        q.addQuestion("CSE 687 is awesome (Leikert):");
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}
