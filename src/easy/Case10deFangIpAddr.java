package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2020/8/12
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class Case10deFangIpAddr {
    public String deFangIPAddr(String address) {
                return address.replace(".", "[.]");
    }
}
