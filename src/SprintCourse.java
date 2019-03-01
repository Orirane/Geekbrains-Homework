public class SprintCourse extends Obstacle {
    protected SprintCourse(int size) {
        super(size);
    }
    @Override
    public void doIt(Animal a) {
        a.run(size);
    }
}
