package cn.net.szwx.sell.controller.manage.system.user;

import cn.net.szwx.sell.controller.BaseController;
import cn.net.szwx.sell.entity.system.user.Member;
import cn.net.szwx.sell.entity.system.user.MemberSO;
import cn.net.szwx.sell.service.system.user.MemberService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/system/user/member")
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("manage/system/user/member/index");
    }

    @ResponseBody
    public JSONObject list(MemberSO so){
        PageInfo<Member> pageInfo = memberService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(required = false) Long id) {
        ModelAndView mv = new ModelAndView("manage/system/user/member/edit");
        if (null != id && id > 0) {
            mv.getModel().put("so", memberService.getById(id));
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping("save")
    public JSONObject save(MemberSO so){
        Member member = new Member();
        if (null != so.getId() && so.getId() > 0) {
            member = memberService.getById(so.getId());
        }
        member.setUsername(StringUtils.trimToNull(so.getUsername()));
        member.setFullname(StringUtils.trimToNull(so.getFullname()));
        member.setNickname(StringUtils.trimToNull(so.getNickname()));
        member.setLockState(so.getLockState());
        if (StringUtils.isNotBlank(so.getPassword())) {
            member.setPassword(DigestUtils.sha1Hex(so.getPassword()));
        }
        member.setWeixinId(StringUtils.trimToNull(so.getWeixinId()));
        member.setIdCardNo(StringUtils.trimToNull(so.getIdCardNo()));
        member.setGrade(so.getGrade());
        member.setOneInviter(so.getOneInviter());
        member.setTwoInviter(so.getTwoInviter());
        member.setThreeInviter(so.getThreeInviter());
        if (null != so.getId() && so.getId() > 0) {
            memberService.update(member);
        } else {
            member.setOneBonus(0.0);
            member.setTwoBonus(0.0);
            member.setThreeBonus(0.0);
            member.setTotalBonus(0.0);
            memberService.insert(member);
        }
        return resultSuccess();
    }

    @ResponseBody
    @RequestMapping("delete")
    public JSONObject delete(@RequestParam Long id){
        memberService.deleteById(id);
        return resultSuccess();
    }
}
