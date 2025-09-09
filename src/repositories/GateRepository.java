package repositories;

import models.Gate;

import java.util.Optional;

public class GateRepository {
    public Optional<Gate> findGateById(int gateId){
        return Optional.empty();
    }
}

/*
in gaterepository layer we wrote an function where by id it will entire row of that gate table
but there is problem here suppose we pass id which does not exist in our table there is solution to solve that
we write optional<Gate> if find the gate we get that particular gate object or we get empty
 */
