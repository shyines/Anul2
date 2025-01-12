public class CalcController {
    private CalcModel m_model;
    private CalcView m_view;

    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view = view;

        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
    }
}
