
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.HashMap;
import java.util.Map;

public class PacienteRepository {
    private Dao<Paciente, Integer> pacienteDao;
    private Map<Integer, Paciente> cache;
    private ConnectionSource connectionSource;
    private StringBuilder log;

    public PacienteRepository(ConnectionSource connectionSource) throws Exception {
        this.connectionSource = connectionSource;
        pacienteDao = DaoManager.createDao(connectionSource, Paciente.class);
        TableUtils.createTableIfNotExists(connectionSource, Paciente.class);
        cache = new HashMap<>();
        log = new StringBuilder();
    }

    public void create(Paciente paciente) throws Exception {
        pacienteDao.create(paciente);
        cache.put(paciente.getId(), paciente);
        log.append("Created: ").append(paciente).append("\n");
    }

    public Paciente read(int id) throws Exception {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            Paciente paciente = pacienteDao.queryForId(id);
            if (paciente != null) {
                cache.put(id, paciente);
            }
            return paciente;
        }
    }

    public void update(Paciente paciente) throws Exception {
        pacienteDao.update(paciente);
        cache.put(paciente.getId(), paciente);
        log.append("Updated: ").append(paciente).append("\n");
    }

    public void delete(int id) throws Exception {
        Paciente paciente = pacienteDao.queryForId(id);
        if (paciente != null) {
            pacienteDao.delete(paciente);
            cache.remove(id);
            log.append("Deleted: ").append(paciente).append("\n");
        }
    }

    public String getLog() {
        return log.toString();
    }

    public void close() throws Exception {
        connectionSource.close();
    }
}
