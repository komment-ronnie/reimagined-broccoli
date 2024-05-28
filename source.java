package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Is a data structure for holding and manipulating page-related information in Spring
 * Data. It contains four fields: currentPage, pageLimit, totalPages, and totalElements.
 * The class provides a constructor for creating instances and a static method for
 * generating new instances based on a Pageable and a Page object.
 */
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
  
  /**
   * Creates a `PageInfo` object containing information about a given pageable and page,
   * such as the current page number, size, total pages, and total elements.
   * 
   * @param pageable pagination information for the current page of data, providing the
   * page number, page size, total pages, and total elements.
   * 
   * @param page current page being processed, providing its total number of elements
   * and pages to the generated `PageInfo`.
   * 
   * @returns a `PageInfo` object containing page number, size, total pages, and total
   * elements.
   */
  public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
