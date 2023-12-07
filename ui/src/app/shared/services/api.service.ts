import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {MatDialog} from "@angular/material/dialog";
import {ErrorComponent} from "../components/error/error.component";

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    constructor(private http: HttpClient, private dialog: MatDialog) {
    }

    private handleError(error: HttpErrorResponse): Observable<never> {
// Implement error handling logic here, e.g., logging the error or showing a user-friendly message.
        console.error('API Error:', error);

        this.dialog.open(ErrorComponent, {
            data: {
                errorMessage: error.error.message
            }
        });

        return new Observable<never>(subscriber => subscriber.error(error));

    }

// Method to perform GET request
    get<T>(url: string): Observable<T> {
        return this.http.get<T>(url).pipe(catchError(this.handleError));
    }

    //get call to get list
    getList<T>(url: string): Observable<T[]> {
        return this.http.get<T[]>(url).pipe(catchError(this.handleError));
    }

// Method to perform POST request
    post<T>(url: string, body: any, options?: { headers?: HttpHeaders }): Observable<T> {
        return this.http.post<T>(url, body, options).pipe(catchError(this.handleError));
    }
}
