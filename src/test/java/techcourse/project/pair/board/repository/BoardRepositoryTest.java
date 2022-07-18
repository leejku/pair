package techcourse.project.pair.board.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import techcourse.project.pair.board.entity.Board;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testBoard() {

        Board board = new Board(null, "aaa", "hi", "realA", "hello", null);

        repository.save(board);

        Board findboard = repository.findByTitle(board.getTitle());

        assertEquals(findboard.getId(), board.getId());
        assertEquals(findboard.getUserid(), board.getUserid());
        assertEquals(findboard, board);
    }

}