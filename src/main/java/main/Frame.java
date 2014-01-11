package main;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Random;

/**
 * Created by ptatyana on 09.01.14.
 */
@Entity
@Table(name="frames")
public class Frame {

    private static Random random = new Random();
    private static Logger logger = LoggerFactory.getLogger(Frame.class);

    private Line line = null;
    private int score = 0;
    private Long id;

    public Frame() {
        score = random.nextInt(10);
    }

    //-------------------------hibernate
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="frame_id")
    public Long getId() {
        return id;
    }

    @Column(name="score")
    public int getScore() {
        return score;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @ManyToOne
    @JoinColumn(name = "line_id")
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

}
