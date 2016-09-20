package auto.newsky.coding.service;

import auto.newsky.coding.po.Concern;

/**
 * Created by prj on 2016/9/16.
 */
public interface IConcern {

    boolean isConcerned(Integer myUserId, Integer concernedUserId);

    boolean concerneUser(Concern concern);

    boolean cancelConcerneUser(Concern concern);



    Concern getConcerne(Integer myUserId, Integer concernedUserId);

    boolean insertConcern(Integer myUserId, Integer concernedUserId);
    public Concern getConcerneTrue(Integer myUserId, Integer concernedUserId);
}
