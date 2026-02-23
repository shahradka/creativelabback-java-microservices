package top.creativelab.user.application.user;

import top.creativelab.user.application.exception.UserNotFoundException;
import top.creativelab.user.domain.user.User;
import top.creativelab.user.ports.inbound.user.ActivateUserUseCase;
import top.creativelab.user.ports.outbound.user.UserRepository;

public class ActivateUserService implements ActivateUserUseCase {
    private UserRepository repository;
    @Override
    public void activateUser(String userName) {
        User user = repository.findUserByUsername((userName)).orElseThrow(() -> new UserNotFoundException(userName));

        user.activate();

        repository.save(user);
    }
}
