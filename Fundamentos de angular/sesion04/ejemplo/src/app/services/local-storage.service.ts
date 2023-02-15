import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageServiceService {

  constructor() { }

  almacenar(key: string, value: any): void{
    localStorage.setItem(key, JSON.stringify(value));
  }

  consultar(key: string){
    return JSON.parse(localStorage.getItem(key)|| '');
  }
  
  consultarTodo(): {[key: string]: any} {
    const result: {[key: string]: any} = {};
    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      if (key !== null) {
        const value = this.consultar(key);
        result[key] = value;
      }
    }
    return result;
  }

  borrar(key: string): void{
    localStorage.removeItem(key);
  }
  
  limpiarTodo(): void{
    localStorage.clear();
  }
}
