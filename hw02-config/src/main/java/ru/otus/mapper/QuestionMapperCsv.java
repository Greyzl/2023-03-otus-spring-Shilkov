package ru.otus.mapper;

import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.entity.csv.QuestionCsv;
import ru.otus.exception.QuestionMapException;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapperCsv {

    public Question mapQuestion(QuestionCsv questionCsv) {
        String questionText = questionCsv.getText();
        if (questionText.isEmpty()) {
            throw new QuestionMapException("Question text is empty");
        }
        String rightAnswerTextTrimmed = questionCsv.getRightAnswer().trim();
        if (rightAnswerTextTrimmed.isEmpty()){
            throw new QuestionMapException("Right answer is empty");
        }
        List<String> answerOptionTexts = questionCsv.getAnswerOptionsList();
        List<Answer> answerOptions = mapAnswerOptions(answerOptionTexts);
        Answer rightAnswer = new Answer(rightAnswerTextTrimmed,true);
        answerOptions.add(rightAnswer);
        return new Question(questionText.trim(), rightAnswer, answerOptions);
    }

    private List<Answer> mapAnswerOptions(List<String> answerOptionTexts){
        var answerOptions = new ArrayList<Answer>();
        for (String answerOptionText: answerOptionTexts) {
            String answerOptionTextTrimmed = answerOptionText.trim();
            if (answerOptionTextTrimmed.isEmpty()){
                continue;
            }
            Answer answerOption = new Answer(answerOptionTextTrimmed, false);
            answerOptions.add(answerOption);
        }
        return answerOptions;
    }
}