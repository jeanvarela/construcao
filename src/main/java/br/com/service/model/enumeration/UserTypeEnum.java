package br.com.service.model.enumeration;

public enum UserTypeEnum {

    CONSTRUCTOR(1),
    MASTER_BUILDER(2) ;

    private final long value;

    UserTypeEnum(int typeId){
        value = typeId;
    }

    public long getValue(){
        return  value;
    }
}
