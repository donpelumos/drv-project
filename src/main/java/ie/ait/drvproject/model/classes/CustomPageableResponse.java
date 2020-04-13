package ie.ait.drvproject.model.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Getter
@Setter
public class CustomPageableResponse<T, U> {
    private String sort;
    private int totalNumberOfElements;
    private int requestedPageSize;
    private int actualPageSize;
    private int currentPage;
    private List<U> content;
    private boolean isFirstPage;
    private boolean isLastPage;

    public CustomPageableResponse(){

    }

    public  CustomPageableResponse(Page<T> items, List<U> itemsWellFormatted){
        this.sort = items.getPageable().getSort().toString().replace(":",",");
        this.totalNumberOfElements = (int)items.getTotalElements();
        this.content = itemsWellFormatted;
        this.requestedPageSize = items.getPageable().getPageSize();
        this.actualPageSize = items.getContent().size();
        this.currentPage = items.getPageable().getPageNumber();
        if(this.totalNumberOfElements < this.requestedPageSize){
            this.isFirstPage = true;
            this.isLastPage = true;
        }
        else if(((this.currentPage + 1) * requestedPageSize ) >= this.totalNumberOfElements){
            this.isLastPage = true;
        }
        else if((this.actualPageSize + currentPage) <= this.requestedPageSize){
            this.isFirstPage = true;
        }
        else{
            this.isFirstPage = false;
            this.isLastPage = false;
        }

    }
}
