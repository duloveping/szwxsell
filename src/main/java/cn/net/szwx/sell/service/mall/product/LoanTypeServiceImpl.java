package cn.net.szwx.sell.service.mall.product;

import cn.net.szwx.sell.dao.mall.product.LoanTypeDao;
import cn.net.szwx.sell.entity.mall.product.LoanType;
import cn.net.szwx.sell.entity.mall.product.LoanTypeSO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoanTypeServiceImpl implements LoanTypeService {
    @Autowired
    private LoanTypeDao loanTypeDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoanType entity) {
        entity.preInsert();
        return loanTypeDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(LoanType entity) {
        entity.preUpdate();
        return loanTypeDao.update(entity);
    }

    @Override
    public List<LoanType> list(LoanTypeSO so) {
        return loanTypeDao.list(so);
    }

    @Override
    public PageInfo<LoanType> findPage(LoanTypeSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<LoanType> pageInfo = new PageInfo(loanTypeDao.list(so));
        return pageInfo;
    }

    @Override
    public LoanType getById(Long id) {
        return loanTypeDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return loanTypeDao.deleteById(id);
    }

    @Override
    public List<LoanType> findRecursive(LoanTypeSO so) {
        return loanTypeDao.findRecursive(so);
    }
}
