package bug_1;

public enum CustomEnum {
    //PLEASE uncomment
    ACTION_ONE(0),
    ACTION_TWO(1),
    ECTION_THREE(2);


    private final int value;
    CustomEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


}
