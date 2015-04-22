package org.chorke.ficon.gui.listeners.workers;

import java.util.Currency;
import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.panels.AccountPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class CreateUpdateAccountSwingWorker extends SwingWorkerWithWaitingDialog<Account, Void> {

    private final boolean create;
    private final AccountPanel infoPanel;

    public CreateUpdateAccountSwingWorker(boolean create, AccountPanel infoPanel) {
        this.create = create;
        this.infoPanel = infoPanel;
    }
    
    @Override
    public Account doYourJob() throws Exception {
        if (create) {
            return createAction();
        } else {
            return updateAction();
        }
    }

    private Account createAction() throws ObjectManipulationException{
        Session ses = Utils.getActualSession();
        String curStr = infoPanel.getCurrency();
        Currency cur;
        try {
            cur = Currency.getInstance(curStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(BundleUtils.getLocalizedMessage(
                    "message.wrong.currency") + " [" + curStr + "]", ex);
        }
        Account account = new Account(ses.getLoggedUser().getId(), cur);
        account.setName(infoPanel.getAccountsName());
        account.setDescription(infoPanel.getAccountsDescription());
        account = ses.createAccount(account);
        return account;
    }

    private Account updateAction() throws ObjectManipulationException{
        Session ses = Utils.getActualSession();
        Account account = ses.getActualAccount();
        if (account == null) {
            GuiUtils.showLocalizedMessageDialog("account.not.set",
                    null, "account.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        account = account.clone();
        account.setName(infoPanel.getAccountsName());
        account.setDescription(infoPanel.getAccountsDescription());
        account = ses.updateAccount(account);
        return account;
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            Account ac = get();
            Utils.getActualSession().setActualAccount(ac);
            WindowUtils.getWindowOfComponent(infoPanel).dispose(); //TODO check if is enough
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t, true);
        }
    }

    @Override
    public void cancelInvoked() {
        try {
            Utils.getActualSession().cancelAllDBOperations();
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t, true);
        }
    }
}
