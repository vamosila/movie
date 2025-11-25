/*
* File: DataAccessible.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.models;

import java.util.List;

public interface DataAccessible<T> {
    public List<T> index();
    public void store(T data);
    public void update(T data, int id);
    public void destroy(int id);
}
