## prolbeme to resolve:
```java
@OneToMany(mappedBy = "commataire")
@JsonIgnoreProperties(value = {"xx"}) // do NOT work
private List<Commantaire> commantaireList = new ArrayList<Commantaire>();

@JsonIgnore
work, but not return commantaireList
```