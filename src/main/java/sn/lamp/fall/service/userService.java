package sn.lamp.fall.service;

import sn.lamp.fall.Model.User;

public interface userService {
	User save(User user);
	User findById(Long id);
}
