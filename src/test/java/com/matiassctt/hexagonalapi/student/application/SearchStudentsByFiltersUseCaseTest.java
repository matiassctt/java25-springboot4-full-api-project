package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.shared.domain.pagination.Pagination;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import com.matiassctt.hexagonalapi.shared.model.request.PaginationRequestFixture;
import com.matiassctt.hexagonalapi.student.fixtures.StudentFixture;
import com.matiassctt.hexagonalapi.student.fixtures.StudentSearchCriteriaFixture;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchStudentsByFiltersUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private SearchStudentsByFiltersUseCase useCase;

    @Test
    void should_search_students_with_filters_successfully() {
        PaginationRequest paginationRequest = PaginationRequestFixture.defaultSortASC();

        StudentSearchCriteria criteria = StudentSearchCriteriaFixture.withFilters();

        Pagination<Student> expectedResult =
                new Pagination<>(
                        List.of(StudentFixture.validStudent()),
                        1,
                        0,
                        1
                );

        when(repository.searchByFilter(paginationRequest, criteria)).thenReturn(expectedResult);

        Pagination<Student> result = useCase.execute(paginationRequest, criteria);

        assertEquals(expectedResult, result);

        verify(repository).searchByFilter(paginationRequest, criteria);
    }

    @Test
    void should_search_students_without_filters() {
        PaginationRequest paginationRequest = PaginationRequestFixture.defaultSortASC();

        StudentSearchCriteria criteria = StudentSearchCriteriaFixture.withoutFilters();

        Pagination<Student> expectedResult = new Pagination<>(List.of(), 0, 0, 0);

        when(repository.searchByFilter(paginationRequest, criteria)).thenReturn(expectedResult);

        Pagination<Student> result = useCase.execute(paginationRequest, criteria);

        assertEquals(0, result.getTotalItems());
    }
}
