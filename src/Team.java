public class Team {
    int teamSize = 0;
    int maxTeamSize;
    Animal[] team = new Animal[4];
    Team(){
        while (teamSize < 4){
            switch (Randomize.giveRandom(2)){
                case 0: team[teamSize] = new Cat(Randomize.giveRandom(200, 400), Randomize.giveRandom(2,4));
                        break;
                case 1: team[teamSize] = new Dog(Randomize.giveRandom(50, 200) , Randomize.giveRandom(300,1000) ,
                        Randomize.giveRandom(1, 3));
                        break;
                case 2: team[teamSize] = new Duck(Randomize.giveRandom(20, 100), Randomize.giveRandom(1000, 3000));
                        break;
                default:team[teamSize] = new Cat(Randomize.giveRandom(200, 400), Randomize.giveRandom(2,4));
                        break;
            }
            teamSize++;
        }


    }
    Team(String member1, String member2, String member3, String member4){
        String[] argArray = new String[4];
        for (String member : argArray){
            switch (member.toLowerCase()){
                case "dog": team[teamSize] = new Dog(Randomize.giveRandom(50, 200) , Randomize.giveRandom(300,1000) ,
                            Randomize.giveRandom(1, 3));
                            break;
                case "cat": team[teamSize] = new Cat(Randomize.giveRandom(200, 400), Randomize.giveRandom(2,4));
                            break;
                case "duck":team[teamSize] = new Duck(Randomize.giveRandom(20, 100), Randomize.giveRandom(1000, 3000));
                            break;
                default:    System.out.println("since you did not choose a valid team member, " +
                        "we put a stray dog on your team instead");
                            break;
            }
            teamSize++;
        }
    }
    void showResults(){
        int i = 0;
        int downedTeammembers = 0;
        for (Animal member : team){
            if (member.isOnDistance()){
                System.out.println(i+ " "+ member.getName()+ " passed the course.");
            }
            else if (!member.isOnDistance()){
                System.out.println(i+ " "+ member.getName()+ " failed the course.");
                downedTeammembers++;
            }
            i++;
        }
        if(downedTeammembers == 4){
            System.out.println("team failed the course.");
        }

    }
}
