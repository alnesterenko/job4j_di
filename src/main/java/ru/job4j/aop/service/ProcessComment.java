package ru.job4j.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.job4j.aop.model.Comment;

@Component
public class ProcessComment {
    private static final Logger LOG = LoggerFactory.getLogger(ProcessComment.class.getName());

    public void publishingComment(Comment comment) {
        LOG.info("Вызван метод:  ProcessComment.publishingComment(..)");
        LOG.info("аргументы: {}", comment);
        System.out.println("Выполняем публикацию комментария : " + comment.getComment());
    }

    public int deleteComment(int commentId) {
        LOG.info("Вызван метод:  ProcessComment.deleteComment(..)");
        LOG.info("аргументы: {}", commentId);
        System.out.println("Выполняем удаление комментария : " + commentId);
        LOG.info("Метод завершил работу: ProcessComment.deleteComment(..)");
        LOG.info("с результатом: {}", commentId);
        return commentId;
    }
}
