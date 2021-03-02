package balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author zhangjie59
 * @date 2021/3/2 22:25
 **/
class Data {

    private final String filename;

    private String content;

    private boolean changed;

    Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    /**
     * 修改数据内容
     * @param newContent 新数据内容
     */
    synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    /**
     * 若数据修改过，则保存到文件中
     * @throws IOException io
     */
    synchronized void save() throws IOException, InterruptedException {
        if (!changed) {
            System.out.println(Thread.currentThread().getName() + " calls save, balking");
            return;
        }

        Thread.sleep(1000);
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content=  " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

}
