package br.com.service.model.enumeration;

public enum UserLoginEnum {

    ADMIN(1),
    USER(2),
    CLIENT(3);

    private final long value;

    UserLoginEnum(int typeId){
        value = typeId;
    }

    public long getValue(){
        return  value;
    }
}
