class Course {
    private Obstacle[] obstacleArray = new Obstacle[Randomize.giveRandom(10)];

    Course(){
        for (int i = 0; i < obstacleArray.length ; i++) {
            switch (Randomize.giveRandom(2)){
                case 0: obstacleArray[i] = new Road(Randomize.giveRandom(10, 500));
                        break;
                case 1: obstacleArray[i] = new Wall(Randomize.giveRandom(3));
                        break;
                case 2: obstacleArray[i] = new Water(Randomize.giveRandom(1, 200));
                        break;
            }
        }
    }
    void doIt(Team team){
        for (Obstacle anObstacleArray : obstacleArray) {
            for (Animal member : team.team) {
                anObstacleArray.doIt(member);
            }
        }
    }
}
