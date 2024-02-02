package entity;

import org.example.tp_devinettes_avec_tests.entity.Riddle;
import org.example.tp_devinettes_avec_tests.exception.RepositoryException;
import org.example.tp_devinettes_avec_tests.repository.Repository;
import org.example.tp_devinettes_avec_tests.repository.RiddleRepository;
import org.example.tp_devinettes_avec_tests.service.RiddleService;
import org.example.tp_devinettes_avec_tests.util.HibernateSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RiddleTest {


    @Mock
    private RiddleService riddleService;

    @BeforeEach
    void setUp() {
        riddleService = new RiddleService(HibernateSession.getSessionFactory(), new RiddleRepository());
    }

    @Test
    void testCreateRiddle() throws RepositoryException {
        // Arrange
        String text = "What has keys but can't open locks?";
        String expectedAnswer = "Piano";
        String userAnswer = "dunno";

        // Act
        boolean result = riddleService.createRiddle(text, expectedAnswer, userAnswer);

        // Assert
        Assertions.assertTrue(result);
    }


    @Test
    void testWhenTheAnswerIsWrong() throws RepositoryException {
        // Arrange
        String text = "What has keys but can't open locks?";
        String expectedAnswer = "Piano";
        String userAnswer = "dunno";

        // Act
        boolean result = riddleService.validateUserAnswer(text, expectedAnswer, userAnswer);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testWhenTheAnswerIsRight() throws RepositoryException {
        // Arrange
        String text = "What has keys but can't open locks?";
        String expectedAnswer = "Piano";
        String userAnswer = "piano";

        // Act
        boolean result = riddleService.validateUserAnswer(text, expectedAnswer, userAnswer);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testWhenTheAnswerIsEmpty() throws RepositoryException {
        // Arrange
        String text = "What has keys but can't open locks?";
        String expectedAnswer = "Piano";
        String userAnswer = " ";

        // Act
        boolean result = riddleService.validateUserAnswer(text, expectedAnswer, userAnswer);

        // Assert
        Assertions.assertFalse(result);
    }
}