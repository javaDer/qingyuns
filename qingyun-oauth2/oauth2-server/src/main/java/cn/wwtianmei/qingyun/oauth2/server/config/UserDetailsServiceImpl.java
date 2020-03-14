package cn.wwtianmei.qingyun.oauth2.server.config;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbPermission;
import cn.wwtianmei.qingyun.oauth2.server.entity.TbUser;
import cn.wwtianmei.qingyun.oauth2.server.service.TbPermissionService;
import cn.wwtianmei.qingyun.oauth2.server.service.TbUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService userService;
    @Autowired
    private TbPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser user = userService.getByUsername(s);
        if (Objects.nonNull(user)) {
            List<TbPermission> tbPermissions = permissionService.selectByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
            tbPermissions.forEach(tb -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tb.getEnname());
                grantedAuthorityList.add(grantedAuthority);
            });
            return new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
        }
        return null;
    }
}
