package kim.nikita.model;


import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {

    public static final Integer START_SEQ=100000;

    @Id
    @SequenceGenerator(name="global_seq",sequenceName = "global_seq",allocationSize = 1,initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "global_seq")
    protected Integer id;

    protected AbstractBaseEntity()
        {

        }

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew()
        {
            return this.id==null;
        }
    @Override
    public String toString()
        {
            return getClass().getSimpleName()+":"+id;
        }

}