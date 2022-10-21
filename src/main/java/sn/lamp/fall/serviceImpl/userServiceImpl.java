package sn.lamp.fall.serviceImpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sn.lamp.fall.Model.User;
import sn.lamp.fall.service.userService;
import sn.lamp.fall.DAO.userRepository;

@Service
public class userServiceImpl implements userService {
	@Autowired
	private userRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User user) {
		User users = new User(user.getPrenom(), user.getNom(), user.getEmail(),
				bCryptPasswordEncoder.encode(user.getPassword()));
    User util=userRepository.findByEmail(users.getEmail()).orElse(new User());
    if(util==null) {
    	return null;}
		return userRepository.save(users);
	}



	public userRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(userRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}


	

	
}
