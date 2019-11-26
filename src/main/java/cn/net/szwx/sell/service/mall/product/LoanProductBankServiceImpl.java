package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanProductBankDao;
import cn.net.szwx.sell.entity.mall.product.LoanProductBank;
import cn.net.szwx.sell.entity.mall.product.LoanProductBankSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanProductBankServiceImpl implements LoanProductBankService {
    @Autowired
    private LoanProductBankDao loanProductBankDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanProductBank entity) {
        entity.preInsert();
        return loanProductBankDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanProductBank entity) {
        entity.preUpdate();
        return loanProductBankDao.update(entity);
    }

    @Override
    public List<LoanProductBank> list(LoanProductBankSO so) {
        return loanProductBankDao.list(so);
    }

    @Override
    public PageInfo<LoanProductBank> findPage(LoanProductBankSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanProductBank> pageInfo = new PageInfo(loanProductBankDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanProductBank getById(Long id) {
        return loanProductBankDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanProductBankDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByProductId(Long productId) {
        loanProductBankDao.deleteByProductId(productId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByBankId(Long bankId) {
        loanProductBankDao.deleteByBankId(bankId);
    }
}
