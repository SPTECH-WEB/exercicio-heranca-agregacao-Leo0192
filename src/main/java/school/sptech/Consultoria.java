package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
   private String nome;
   private Integer vagas;
   private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() == true) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double salarioTotal = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            salarioTotal += desenvolvedor.calcularSalario();
        }
        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer total = 0;
        for (Desenvolvedor desenvolvedorMobile : desenvolvedores) {
            if (desenvolvedorMobile instanceof DesenvolvedorMobile) {
                total += 1;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> desenvolvedors2 = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                desenvolvedors2.add(desenvolvedor);
            }
        }
        return desenvolvedors2;
    }

    public Desenvolvedor buscarMenorSalario() {

        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor desenvolvedor1 = desenvolvedores.get(0);

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor1.calcularSalario() > desenvolvedor.calcularSalario()) {
                desenvolvedor1 = desenvolvedor;
            }
        }
        return desenvolvedor1;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedores2 = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia)) {
                    desenvolvedores2.add(dev);
                }
            }
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)) {
                    desenvolvedores2.add(dev);
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia)) {
                    desenvolvedores2.add(dev);
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)) {
                    desenvolvedores2.add(dev);
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getBackend().equals(tecnologia)) {
                    desenvolvedores2.add(dev);
                }
            }
        }
        return desenvolvedores2;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double salarioTotal = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia)) {
                    salarioTotal += dev.calcularSalario();
                }
            }
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)) {
                    salarioTotal += dev.calcularSalario();
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia)) {
                    salarioTotal += dev.calcularSalario();
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)) {
                    salarioTotal += dev.calcularSalario();
                }
            }

            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getBackend().equals(tecnologia)) {
                    salarioTotal += dev.calcularSalario();
                }
            }
        }
        return salarioTotal;
    }
}
