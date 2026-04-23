package com.library.interfaces;

import com.library.core.Library;

public interface LendingService {
    Library.LoanRecord lend(int shelfNumber, String borrowerName);

}
