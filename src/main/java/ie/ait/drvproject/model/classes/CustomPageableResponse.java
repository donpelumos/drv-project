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
    private int requestedCurrentPageSize;
    private int actualCurrentPageSize;
    private int currentPage;
    private List<U> content;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int totalNumberOfPages;

    public CustomPageableResponse(){

    }

    public  CustomPageableResponse(Page<T> items, List<U> itemsWellFormatted){
        this.sort = items.getPageable().getSort().toString().replace(":",",");
        this.totalNumberOfElements = (int)items.getTotalElements();
        this.content = itemsWellFormatted;
        this.requestedCurrentPageSize = items.getPageable().getPageSize();
        this.actualCurrentPageSize = items.getContent().size();
        this.currentPage = items.getPageable().getPageNumber();
        if(this.totalNumberOfElements < this.requestedCurrentPageSize){
            this.isFirstPage = true;
            this.isLastPage = true;
        }
        else if(((this.currentPage + 1) * requestedCurrentPageSize) >= this.totalNumberOfElements){
            this.isLastPage = true;
        }
        else if((this.actualCurrentPageSize + currentPage) <= this.requestedCurrentPageSize){
            this.isFirstPage = true;
        }
        else{
            this.isFirstPage = false;
            this.isLastPage = false;
        }
        this.totalNumberOfPages = (int)Math.ceil(((double)this.totalNumberOfElements)/((double)this.requestedCurrentPageSize));
    }
}
