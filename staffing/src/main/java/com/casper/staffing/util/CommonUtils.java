package com.casper.staffing.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public final class CommonUtils {
    public static boolean isNull(final Object object) {
        return null == object;
    }

    public static boolean isNotNull(final Object object) {
        return !isNull(object);
    }

    public static PageRequest createPageRequest(final int page,
                                                final int pageSize,
                                                final String sortBy,
                                                final String direction) {
        final Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return PageRequest.of(page - 1, pageSize, sort);
    }

    private CommonUtils() { }
}
